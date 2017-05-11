package com.ws1001.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.io.IOException;

import static java.util.Collections.emptyList;

import com.ws1001.repositories.UserRepository;
import com.ws1001.models.User;

class TokenAuthenticationService {

  private static UserRepository userRepository;

  static final long EXPIRATIONTIME = 864_000_000; // 10 days
  static final String SECRET = "ThisIsASecret";
  static final String TOKEN_PREFIX = "Bearer";
  static final String HEADER_STRING = "Authorization";
  static final String HEADER_CORS = "Access-Control-Allow-Origin";
  static final String RS_ORIGIN = "http://localhost:4200";

  //ovdje cemo morati dodati uloge u odgovor da bi na klijentskoj strani znali privilegije
  static void addAuthentication(HttpServletResponse res, String username) throws IOException{
      String JWT = Jwts.builder()
          .setSubject(username)
          .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
          .signWith(SignatureAlgorithm.HS512, SECRET)
          .compact();
      res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
      res.addHeader(HEADER_CORS, RS_ORIGIN);
      String str1 = "{ \"jwt\" : ";
      String str2 = "\"" + JWT + "\" }";
      res.getWriter().write(str1 + str2);
  }

  static Authentication getAuthentication(HttpServletRequest request) {
      
      ServletContext servletContext = request.getServletContext();
      WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
      userRepository = webApplicationContext.getBean(UserRepository.class);

      String token = request.getHeader(HEADER_STRING);
      if (token != null) {
    
        String userReq = Jwts.parser()
            .setSigningKey(SECRET)
            .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
            .getBody()
            .getSubject();

      User user = userRepository.findByUsername(userReq);

      Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

      if (user != null) {
          grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
      }     

      return userReq != null ?
          new UsernamePasswordAuthenticationToken(userReq, null, grantedAuthorities) : //emptyList()
          null;
      }
      return null;
  }
}