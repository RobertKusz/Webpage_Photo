function deletePhoto(sessionId, photoId) {
    if (!confirm('Na pewno usunąć to zdjęcie?')) return;

    fetch(`/admin/edytuj_sesje/${sessionId}/delete-photo?photoId=${photoId}`, {
        method: 'POST',
        headers: {
            'X-Requested-With': 'XMLHttpRequest'
        }
    }).then(response => {
        if (response.ok) {
            location.reload(); // Odśwież stronę bez dodania do historii przeglądarki
        } else {
            alert("Wystąpił błąd podczas usuwania zdjęcia.");
        }
    }).catch(error => {
        console.error('Błąd:', error);
        alert("Wystąpił błąd po stronie klienta.");
    });
}
