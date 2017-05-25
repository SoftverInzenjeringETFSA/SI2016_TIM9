import Ember from 'ember';
import AuthenticatedRoute from './authenticated-route';
import Inventory from '../models/inventory';

export default AuthenticatedRoute.extend({
  inventoryService: Ember.inject.service(),

  model: function() {
    console.log("ajla3");
    return Ember.RSVP.hash({

      inventories: this.get('inventoryService').all(),
      inventory: Inventory.create({label: 0, name: ""}),
    });
  },

  setupController: function(controller, model) {
    this._super(controller, model);
    controller.set('filterTerm', '');
  }
});
