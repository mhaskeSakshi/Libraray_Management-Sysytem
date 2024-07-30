document.getElementById('addBookForm').addEventListener('submit', function(e) {
    e.preventDefault(); // Prevent the default form submission

    const title = document.getElementById('titleInput').value; // Use titleInput ID
    const author = document.getElementById('author').value;
    const year = document.getElementById('year').value;

    // Send the book details to the server
    fetch('/addBook', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ title, author, year }) // Convert to JSON
    }).then(response => response.json())
    .then(data => {
        if (data.success) {
            alert('Book added successfully');
            document.getElementById('addBookForm').reset(); // Reset the form
        } else {
            alert('Error adding book');
        }
    }).catch(error => {
        console.error('Error:', error);
        alert('Error adding book');
    });
});
