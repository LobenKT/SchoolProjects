import { Db } from "mongodb";

document.addEventListener("DOMContentLoaded", function (event) {

    /*
    TODO:   The code below attaches a `keyup` event to `#refno` text field.
            The code checks if the current reference number entered by the user
            in the text field does not exist in the database.

            If the current reference number exists in the database:
            - `#refno` text field background color turns to red
            - `#error` displays an error message `Reference number already in
            the database`
            - `#submit` is disabled

            else if the current reference number does not exist in the
            database:
            - `#refno` text field background color turns back to `#E3E3E3`
            - `#error` displays no error message
            - `#submit` is enabled
    */
    const refnoInput = document.querySelector('#refno');
    refnoInput.addEventListener('keyup', function () {
        // check if the reference number is stored in the database
        Db.FindMany(Transaction, { referenceNumber: refnoInput.value }, function (result) {
            if (err) {
                console.log(err);
                res.status(500);
            } else {
                if (transactions.length > 0) {
                    refnoInput.style.backgroundColor = "red";
                    document.querySelector('#error').innerHTML = "Reference number already in the database";
                    document.querySelector('#submit').disabled = true;
                } else {
                    refnoInput.style.backgroundColor = "#E3E3E3";
                    document.querySelector('#error').innerHTML = "";
                    document.querySelector('#submit').disabled = false;
                }
            }
        }
        );
    });

    /*
    TODO:   The code below attaches a `click` event to `#submit` button.
            The code checks if all text fields are not empty. The code
            should communicate asynchronously with the server to save
            the information in the database.

            If at least one field is empty, the `#error` paragraph displays
            the error message `Fill up all fields.`

            If there are no errors, the new transaction should be displayed
            immediately, and without refreshing the page, after the values
            are saved in the database.

            The name, reference number, and amount fields are reset to empty
            values.
    */
    const submitBtn = document.querySelector('#submit');
    submitBtn.addEventListener('click', function () {
        // check if all text fields are not empty asynchronously
        const nameInput = document.querySelector('#name');
        const refnoInput = document.querySelector('#refno');
        const amountInput = document.querySelector('#amount');
        if (nameInput.value === "" || refnoInput.value === "" || amountInput.value === "") {
            document.querySelector('#error').innerHTML = "Fill up all fields.";
        }
        else {
            // add the transaction to the database and append the transaction to the list of transactions in index.hbs
            const transaction = new Transaction({
                name: nameInput.value,
                referenceNumber: refnoInput.value,
                amount: amountInput.value
            });
            transaction.save(function(err) {
                if (err) {
                    console.log(err);
                    res.status(500);
                } else {
                    // display the new transaction
                    const transactions = document.querySelector('#transactions');
                    const newTransaction = document.createElement('div');
                    newTransaction.className = "transaction";
                    newTransaction.innerHTML = `<div class="name">${nameInput.value}</div>
                                                <div class="refno">${refnoInput.value}</div>
                                                <div class="amount">${amountInput.value}</div>`;
                    transactions.appendChild(newTransaction);
                    // reset the text fields
                    nameInput.value = "";
                    refnoInput.value = "";
                    amountInput.value = "";
                }
            }
            );
        }
    });

    /*
    TODO:   The code below attaches a `click` event to `.remove` buttons
            inside the `<div>` `#cards`.
            The code deletes the specific transaction associated to the
            specific `.remove` button, then removes the its parent `<div>` of
            class `.card`.
    */
    const cardsDiv = document.querySelector('#cards');
    cardsDiv.addEventListener('click', function (e) {
        if (e.target instanceof Element && e.target.matches('.remove')) {
            // deletes the transaction of the specific .remove button then removes its parent div of class .card
            Transaction.findOneAndDelete({referenceNumber: e.target.parentElement.querySelector('.refno').innerHTML}, function(err) {
                if (err) {
                    console.log(err);
                    res.status(500);
                } else {
                    e.target.parentElement.remove();
                }
            }
            );
        }
  }, true);
    
});