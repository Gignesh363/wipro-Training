function confirmDelete(id) {
    if (confirm("Are you sure you want to delete this client?")) {
        window.location.href = "/deleteClient/" + id;
    }
}
