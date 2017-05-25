import Ember from 'ember';
import TakenKey from '../models/takenKey';


export default Ember.Controller.extend(Validations, {
    takenKeyService: Ember.inject.service(),
    flashMessages: Ember.inject.service(),

    showNewTakenKey: false,

    actions: {
        add() {
//            const flashMessages = Ember.get(this, 'flashMessages');
//            this.get('takenKeyService').create(this.get('model.takenKey')).then(function(newTakenKey) {
//                this.get('model.takenKey').pushObject(TakenKey.create(newTakenKey));
//                this.set('model.takenKey', TakenKey.create({/*JSON KREACIJE*/}));
//                flashMessages.success("Ključ iznajmljen.");
//                this.toggleProperty('showNewTakenKey');
//            }.bind(this), function() {
//                flashMessages.danger("Greška pri izdavanju ključa.");
//                this.toggleProperty('showNewTakenKey');
//            }.bind(this));
        },

        delete(takenKey) {
           //implement
        },


        selectStatus(takenKey) {
            //this.set('model.classroom.classroom', classroom);
        },
        selectClassroom(classroom) {
            //this.set('model.classroom.teacherId', teacher.id);
        }
    }
});
