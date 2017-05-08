import Ember from 'ember';
import AuthenticatedRouteMixin from 'ember-simple-auth/mixins/authenticated-route-mixin';

//ovo znaci da samo onaj korisnik koji je prijavljen moze pristupiti ruti /korisnici
//svrha: testiranje uspjesnosti logina
export default Ember.Route.extend(AuthenticatedRouteMixin);