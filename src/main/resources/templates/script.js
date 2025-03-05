function deposit() {
    let userId = document.getElementById("userId").value;
    let amount = document.getElementById("amount").value;

    fetch(`http://localhost:8080/account/deposit/${userId}?amount=${amount}`, {
        method: "POST"
    })
        .then(response => response.text())
        .then(data => {
            document.getElementById("result").innerText = data;
        })
        .catch(error => console.error("Error:", error));
}

function withdraw() {
    let userId = document.getElementById("userId").value;
    let amount = document.getElementById("amount").value;

    fetch(`http://localhost:8080/account/withdraw/${userId}?amount=${amount}`, {
        method: "POST"
    })
        .then(response => response.text())
        .then(data => {
            document.getElementById("result").innerText = data;
        })
        .catch(error => console.error("Error:", error));
}
