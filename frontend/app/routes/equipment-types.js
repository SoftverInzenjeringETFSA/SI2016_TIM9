import Ember from 'ember';
import Equipment from '../models/equipment';

export default Ember.Route.extend({
	equipmentTypeService: Ember.inject.service(),

    model: function() {
        return Ember.RSVP.hash({
            types: this.get('equipmentTypeService').all(),
            equipment: Equipment.create({ label: "", name: "" }),
        });
    },
});
