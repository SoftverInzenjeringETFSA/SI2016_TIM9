import Ember from 'ember';
import ApplicationRouteMixin from 'ember-simple-auth/mixins/application-route-mixin';

export default Ember.Route.extend(ApplicationRouteMixin, {
	session: Ember.inject.service(),
	/*actions: {
		//poziva se za logout
		invalidateSession: function(){
			this.get('session').invalidate();
		},
	},
    renderTemplate: function() {
        // Treba dodati kondicionalno prikazivanje ovisno o prijavi korisnika
        // Kad nije prijavljen: this.render('login')
        this.render('layouts/logged-in');
    }*/
});
