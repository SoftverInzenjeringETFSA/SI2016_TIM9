import Ember from 'ember';
import AuthenticatedRoute from './authenticated-route';
import Classroom from '../models/classroom';

export default AuthenticatedRoute.extend({
    classroomService: Ember.inject.service(),
    userService: Ember.inject.service(),

	model: function() {
		return Ember.RSVP.hash({
			classrooms: this.get('classroomService').all(),
			classroom: Classroom.create({name: "", seatCount: 15, keyCount: 4, teacherId: -1, status: 0, type: 0}),
			users: this.get('userService').all()
		});
	},

	setupController: function(controller, model) {
	    this._super(controller, model);
	    controller.set('filterTerm', '');
  	}
});