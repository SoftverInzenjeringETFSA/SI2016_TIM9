import Ember from 'ember';
import AuthenticatedRoute from './authenticated-route';
import User from '../models/user';

export default AuthenticatedRoute.extend({
    userService: Ember.inject.service(),

	model: function() {
		return Ember.RSVP.hash({
			users: this.get('userService').all(),
			user: User.create({username: "", password: "", firstName: "", lastName: "", type: 0}),
		});
	},

	setupController: function(controller, model) {
	    this._super(controller, model);
	    controller.set('filterTerm', '');
  	}
});