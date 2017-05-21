import Ember from 'ember';
import BaseService from './base-service';
import User from '../models/user';

export default BaseService.extend({
	usernameExists: function(email) {
    	return this.ajax({ url: `users/exists/${email}`, type: "GET" });
    },

    // admin    
    all: function() {
        var users = [];
        this.ajax({ url: "users/all", type: "GET" }).then(function(data) {
            data.forEach(function(user) {
                users.addObject(User.create(user));
            });
        });    
        return users;
    },

    getById: function(id) {
        var user = User.create({});
        this.ajax({ url: `users/${id}`, type: "GET"}).then(function(data) {
            user.setProperties(data);
        });        

        return user;
    },


    edit: function(userId, data) {
        return this.ajax({ url: `users/${userId}`, type: "PUT", data: JSON.stringify(data) });
    },

    create: function(data) {
        return this.ajax({ url: `users`, type: "POST", data: JSON.stringify(data)})
    },

    delete: function(userId) {
        return this.ajax({ url: `users/${userId}`, type: "DELETE"});
    },
});
