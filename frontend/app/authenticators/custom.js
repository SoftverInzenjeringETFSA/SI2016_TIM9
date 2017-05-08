import Ember from 'ember';  
import Base from 'ember-simple-auth/authenticators/base';  
import config from '../config/environment';

//ES6 sintaksa aka elvish stuff
const { RSVP: { Promise }, $: { ajax }, run } = Ember;

export default Base.extend({  
  tokenEndpoint: `${config.host}/login`,
  restore(data) {
    return new Promise((resolve, reject) => {
      if (!Ember.isEmpty(data.token)) {
        resolve(data);
      } else {
        reject();
      }
    });
  },
  authenticate(creds) {

    const { identification, password } = creds;
    const data = JSON.stringify({
     
        username: identification,
        password
      
    });
    const requestOptions = {
      url: this.tokenEndpoint,
      type: 'POST',
      data,
      //kada se postavi i contentType header pocnu se desavati neke cudne anomalije vezane za CORS
      //bitno je da se moze i bez njega uraditi
      //contentType: 'application/json',
      dataType: 'json'
    };
    return new Promise((resolve, reject) => {
      ajax(requestOptions).then((response) => {
        //treba dodati da se vraca i tip korisnika (operater, admin, nastavnik)
		const { jwt } = response;
        run(() => {
			//resolve spasava JWT u localstorage da bi se kasnije mogao koristiti
          resolve({
            token: jwt,
          });
        });
      }, (error) => {
        run(() => {
          reject(error);
        });
      });
    });
  },
  invalidate(data) {
    return Promise.resolve(data);
  }
});