import Ember from 'ember';
import AdminRoute from './admin-route';
import User from '../models/user';

export default AdminRoute.extend({
    userService: Ember.inject.service(),

	model: function() {
		return Ember.RSVP.hash({
			users: this.get('userService').all(),
			user: User.create({username: "", password: "", firstName: "", lastName: "", type: 0}),
		});
	}
});