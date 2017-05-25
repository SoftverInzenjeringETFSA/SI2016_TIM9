import Ember from 'ember';
import Inventory from '../models/inventory';



export default Ember.Controller.extend( {
  inventoryService: Ember.inject.service(),
  flashMessages: Ember.inject.service(),


  filterTerm: '',

  filterByTerm: function() {
    var term = this.get('filterTerm');
    if (term.length >= 3) {
      this.set('model.inventories', this.get('inventoryService').filterByTerm(this.get('filterTerm')));
    } else if (term === "") {

      this.set('model.inventories', this.get('inventoryService').all());
    }
  },

  debounceFilter: function() {
    Ember.run.debounce(this, this.filterByTerm, 400);
  }.observes('filterTerm'),






});
