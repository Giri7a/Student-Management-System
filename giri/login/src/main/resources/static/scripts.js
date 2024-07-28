
    document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault();// Prevents the default form submission behavior

    // Retrieve username and password from form input fields
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    //  // Send an asynchronous POST request to the server-side login API endpoint
    const response = await fetch('/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    });

    // Extract the text content of the response (typically the message from the server)
    const result = await response.text();

    //// Get the message element from the HTML document
    const messageDiv = document.getElementById('message');

    // Check the result of the login attempt
    if (result === 'Login successful') {
     // Display success message in messageDiv and redirect to student.html
        messageDiv.textContent = result;
        window.location.href = 'student.html'; // Redirect to the student.html page
    } else {
     // Display error message returned from the server
        messageDiv.textContent = result;
    }
});



