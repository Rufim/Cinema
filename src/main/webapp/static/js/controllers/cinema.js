'use strict';

/**
 * CinemaController
 * @constructor
 */
var CinemaController = function ($scope, $http) {

    $scope.fetchCinema = function () {
        $http.get('cinema/cinema.json').then(function successCallback(response) {
            var cinema = response.data;
            $scope.cinema = cinema;
            $scope.hall = cinema.hall;
            $scope.seats = cinema.hall.seats;
            $scope.rows = $scope.getRows($scope.seats);
        }, function errorCallback(response) {
            console.log(response)
        });
    };

    $scope.reserveSeat = function (seat) {
        if(!seat.reserved) {
            $http.post('cinema/reserve/', seat).then(function successCallback() {
                $scope.fetchCinema();
            });
        }
    };


    $scope.getRows = function (seats) {
        var rows = [];
        var row;
        seats.forEach(function (seat) {
            if (row == null || seat.row != row.title) {
                row = {title: seat.row, seats: []};
                rows.push(row)
            }
            row.seats.push(seat);
        })
        return rows;
    };

    $scope.fetchCinema();
};