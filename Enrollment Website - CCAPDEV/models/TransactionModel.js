import mongoose from "mongoose";

/*
    TODO:   Complete the TransactionSchema which will contain the name,
            reference number, and the amount of a transaction in the database.
*/
const TransactionSchema = new mongoose.Schema({
    // Store the name of the transaction, reference number, and amount of the transaction
    name: {
        type: String,
        required: true
    },
    referenceNumber: {
        type: String,
        required: true
    },
    amount: {
        type: Number,
        required: true
    }
});

const Transaction = mongoose.model('Transaction', TransactionSchema);

export default Transaction;