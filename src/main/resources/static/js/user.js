document.querySelectorAll('.deleteForm').forEach((form) => {
  form.addEventListener('submit', (e) => {
    e.preventDefault();

    if (confirm('本当に削除してもよろしいですか？')) {
      e.target.submit();
    }
  });
});
