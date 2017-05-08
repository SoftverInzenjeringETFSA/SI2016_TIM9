import Ember from 'ember';

export default Ember.Controller.extend({
	session: Ember.inject.service(),
	validationError: "",
	authenticationError: "",
	actions: {
		authenticate: function() {
			var credentials = this.getProperties('identification', 'password'), authenticator = 'authenticator:custom';
			
			this.set('validationError','');

			if(!credentials.identification || !credentials.password){
				this.set('validationError','Polja za unos ne smiju biti prazna');
				return;
			}
			
			if(!credentials.identification.match(/^[a-z0-9]+$/i)){
				this.set('validationError','Korisnicko ime moze sadrzavari iskljucivo alfanumericke znakove.');
				return;
			}

			if(credentials.password.length<=6){
				this.set('validationError','Lozinka mora biti duza od 6 znakova.');
				return;
			}
			this.get('session').authenticate(authenticator, credentials).catch((reason)=>{
				this.set('authenticationError', reason.error || reason);
			});
		}
	}
});
