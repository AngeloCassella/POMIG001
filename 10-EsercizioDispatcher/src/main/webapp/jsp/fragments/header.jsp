<%@ page import="java.time.LocalDate" %>
<%@ page import="servlet.PrenotazioneServlet" %>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <a class="nav-link active" aria-current="page" href="/">Home</a>
          <a class="nav-link" href="/prenota">Prenota</a>
          <a class="nav-link" href="/lista">Lista Prenotazioni</a>
        </div>
      </div>
      <span class="navbar-text">
         Prenotazioni totali: ${PrenotazioneServlet.getPrenotazioni().size()} - ${LocalDate.now()}
      </span>
    </div>
  </nav>