import Ember from 'ember';
import BaseService from './base-service';
import TakenKey from '../models/takenKey';

export default BaseService.extend({
	nameExists: function(name) {
    	//return this.ajax({ url: `classrooms/exists`, type: "POST", data: JSON.stringify({"name": name}) });
    },

    // admin    
    all() {
        var takenKeys = [];
        this.ajax({ url: "takenKeys/all", type: "GET" }).then(function(data) {
            data.forEach(function(takenKey) {
                takenKeys.addObject(TakenKey.create(takenKey));
            });
        });    
        return takenKeys;
    },

    filterByTerm(term) {
    //implement
    },

    getById(id) {
        var takenKey = TakenKey.create({});
        this.ajax({ url: `takenKeys/${id}`, type: "GET"}).then(function(data) {
            takenKey.setProperties(data);
        });        

        return takenKey;
    },

    edit(takenKeyId, data) {
        //return this.ajax({ url: `classrooms/${userId}`, type: "PUT", data: JSON.stringify(data) });
    },

    create(data) {
//        if(data.get('teacherId') === -1) { data.set('teacherId', null); }
//        return this.ajax({ url: `classrooms`, type: "POST", data: JSON.stringify(data)})
    },

    delete(takenKeyId) {
//        return this.ajax({ url: `classrooms/${userId}`, type: "DELETE"});
    },
});
