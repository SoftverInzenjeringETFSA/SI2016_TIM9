import Ember from 'ember';
import AuthenticatedRoute from './authenticated-route';

export default AuthenticatedRoute.extend({
	redirect: function() {
		this.get('session').invalidate();
		this.transitionTo('login');
	}
});