/**
 * @ngdoc overview
 * @name CinemaApp
 * @requires ngRoute
 * @requires ngResource
 * @description
 * Creates an Angular application.
 * */
'use strict';

var CinemaApp = {};

var App = angular.module('CinemaApp', [
    'ngRoute',
    'ngResource']);

App.config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when('/cinema', {
            templateUrl: '/cinema',
            controller: CinemaController
        })
        .when('/settings', {
            templateUrl: '/settings',
            controller: SettingsController
        })
        .when('/users', {
            templateUrl: '/users',
            controller: UsersController
        })
        .when('/registration/:step', {
            templateUrl: function(params) {
                return '/registration/' + params.step;
            },
            controller: RegistrationController
        })
        .otherwise({
            redirectTo: '/'
        });

    // use the HTML5 History API
    $locationProvider.html5Mode(true);
});


