package controllers;

import models.Tournament;

public class TournamentController {
  public void sortSelectionDes(Tournament[] tournaments) {
    int n = tournaments.length;
    for (int i = 0; i < n - 1; i++) {
      int maxIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (tournaments[j].getTotalStarterPoints() > tournaments[maxIndex].getTotalStarterPoints()) {
          maxIndex = j;
        }
      }
      Tournament aux = tournaments[i];
      tournaments[i] = tournaments[maxIndex];
      tournaments[maxIndex] = aux;

    }
  }

  public Tournament binarySearchByTotalStarterPointsFilaB(Tournament[] tournaments, int totalStarterPoints) {
    sortSelectionDes(tournaments);
    int bajo = 0;
    int alto = tournaments.length - 1;
    while (bajo <= alto) {
      int centro = (bajo + alto) / 2;
      int valorCentro = tournaments[centro].getTotalStarterPoints();
      if (valorCentro == totalStarterPoints) {
        return tournaments[centro];
      }
      if (valorCentro < totalStarterPoints) {
        alto = centro - 1;
      } else {
        bajo = centro + 1;
      }

    }
    return null;
  }

}
