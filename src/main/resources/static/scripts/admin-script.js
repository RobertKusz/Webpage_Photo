document.addEventListener('DOMContentLoaded', function () {
    const deleteButtons = document.querySelectorAll('.delete-photo-btn');

    const csrfTokenMeta = document.querySelector('meta[name="_csrf"]');
    const csrfHeaderMeta = document.querySelector('meta[name="_csrf_header"]');
    const container = document.querySelector('.session-gallery-container');

    // Bezpieczne pobranie danych (z ochroną przed null)
    const csrfToken = csrfTokenMeta?.getAttribute('content');
    const csrfHeader = csrfHeaderMeta?.getAttribute('content');
    const sessionId = container?.getAttribute('data-session-id');
    const userId = container?.getAttribute('data-user-id');

    // Jeśli którykolwiek z elementów nie istnieje, przerwij
    if (!csrfToken || !csrfHeader || !sessionId || !userId) {
        console.error("Brakuje danych CSRF lub identyfikatorów użytkownika/sesji.");
        return;
    }

    deleteButtons.forEach(button => {
        button.addEventListener('click', function () {
            const photoId = button.getAttribute('data-photo-id');
            if (!photoId) return;

            if (!confirm('Na pewno usunąć to zdjęcie?')) return;

            fetch(`/admin/${userId}/edytuj_sesje/${sessionId}/delete-photo?photoId=${photoId}`, {
                method: 'POST',
                headers: {
                    'X-Requested-With': 'XMLHttpRequest',
                    [csrfHeader]: csrfToken
                }
            })
            .then(response => {
                if (response.ok) {
                    location.reload();
                } else {
                    alert("Wystąpił błąd podczas usuwania zdjęcia.");
                }
            })
            .catch(error => {
                console.error('Błąd:', error);
                alert("Wystąpił błąd po stronie klienta.");
            });
        });
    });
});
