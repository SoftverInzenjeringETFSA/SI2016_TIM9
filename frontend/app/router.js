import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('login');
  this.route('users');
  this.route('classrooms');
  this.route('reports');
  this.route('inventory');
  this.route('loged-in');
});

export default Router;
