document.getElementById('uploadForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const fileInput = document.getElementById('fileInput');
    const formData = new FormData();
    
    for (let i = 0; i < fileInput.files.length; i++) {
        formData.append("files", fileInput.files[i]);
    }

    fetch('http://localhost:8080/api/files/upload', {
        method: 'POST',
        body: formData
    })
    .then(response => response.blob())
    .then(data => {
        const link = document.createElement('a');
        link.href = URL.createObjectURL(data);
        link.download = 'uploaded-files-archieve.zip';
        link.click();
    })
    .catch(error => {
        console.error('Error uploading frontend :', error);
        document.getElementById('message').textContent = 'Error uploading files!';
    });
});

document.getElementById('downloadForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const fileName = document.getElementById('fileName').value;
    
    fetch(`http://localhost:8080/api/files/download/${fileName}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    })
    .then(response => response.blob())
    .then(data => {
        const link = document.createElement('a');
        link.href = URL.createObjectURL(data);
        link.download = fileName;
        link.click();
    })
    .catch(error => {
        document.getElementById('message').textContent = 'Error downloading file!';
    });
});
