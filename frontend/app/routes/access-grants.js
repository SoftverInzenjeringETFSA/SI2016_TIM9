import Ember from 'ember';
import Access from '../models/access';

export default Ember.Route.extend({
	userService: Ember.inject.service(),
	classroomService: Ember.inject.service(),

    model: function(params, transition) {
        return Ember.RSVP.hash({
            users: this.get('userService').all(),            
            classroom: this.get('classroomService').getById(params.id),
            access: Access.create({ userId: "", classroomId: params.id }),
        });
    },
});
