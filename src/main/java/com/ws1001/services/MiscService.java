package com.ws1001.services;

import com.ws1001.models.User;
import com.ws1001.repositories.ClassroomRepository;
import com.ws1001.repositories.UserRepository;
import com.ws1001.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiscService  {


    private UserRepository userRepository;

    private ClassroomRepository classroomRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setClassroomRepository(ClassroomRepository classroomRepository) { this.classroomRepository = classroomRepository; }

    public GlobalStats getGlobalStats() {
        return new GlobalStats(userRepository.count(), classroomRepository.count());
    }

    public class GlobalStats {
        private Long userCount;
        private Long classroomCount;

        public GlobalStats() {

        }

        public GlobalStats(Long userCount, Long classroomCount) {
            this.userCount = userCount;
            this.classroomCount = classroomCount;
        }

        public Long getUserCount() {
            return userCount;
        }

        public void setUserCount(Long userCount) {
            this.userCount = userCount;
        }

        public Long getClassroomCount() {
            return classroomCount;
        }

        public void setClassroomCount(Long classroomCount) {
            this.classroomCount = classroomCount;
        }
    }
}