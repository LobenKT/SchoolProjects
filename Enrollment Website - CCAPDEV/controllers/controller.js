import db from '../models/db.js';
import Transaction from '../models/TransactionModel.js';

const controller = {

    
    getFavicon: function (req, res) {
        res.status(204);
    },

    /*
    TODO:   This function is executed when the client sends an HTTP GET
            request to path `/`. This displays `index.hbs` with all
            transactions currently stored in the database.
    */
    getIndex: function(req, res) {
        // find the transactions stored in the db and display them in index.hbs
        db.findMany(Transaction, {}, {}, function(result) {
            if (result) {
                res.render('index', {transactions: result});
            } else {
                res.status(500);
            }
        }
        );
    }
    ,

    /*
    TODO:   This function is executed when the client sends an HTTP GET
            request to path `/getCheckRefNo`. This function checks if a
            specific reference number is stored in the database. If the number
            is stored in the database, it returns an object containing the
            reference number, otherwise, it returns an empty string.
    */
    getCheckRefNo: function(req, res) {
        // check if the reference number is stored in the database, return object if yes, return empty string if not
        db.findOne(Transaction, {referenceNumber: req.query.referenceNumber}, function(result) {
            if (result) {
                //return object with referenceNumber
                res.send(result);
            } else {
                //return empty string
                res.send("");
            }
        }
        );
    },



    /*
    TODO:   This function is executed when the client sends an HTTP GET
            request to path `/getAdd`. This function adds the transaction
            sent by the client to the database, then appends the new
            transaction to the list of transactions in `index.hbs`.
    */
    getAdd: function(req, res) {
        // add the transaction to the database and append the transaction to the list of transactions in index.hbs
        const transaction = new Transaction({
            name: req.query.name,
            referenceNumber: req.query.referenceNumber,
            amount: req.query.amount
        });
        transaction.save(function(err) {
            if (err) {
                console.log(err);
                res.status(500);
            } else {
                // display the new transaction
                res.redirect('/');
            }
        }
        );
    },

    /*
    TODO:   This function is executed when the client sends an HTTP GET
            request to path `/getDelete`. This function deletes the transaction
            from the database, then removes the transaction from the list of
            transactions in `index.hbs`.
    */
    getDelete: function (req, res) {
        // delete the transaction from the database and remove the transaction from the list of transactions in index.hbs
        db.deleteOne(Transaction, {referenceNumber: req.query.referenceNumber}, function(result) {
            if (result) {
                res.redirect('/');
            } else {
                res.status(500);
            }
        }
        );
    },
};

export default controller;