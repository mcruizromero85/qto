Scenario: Test

Given I open the web application
Then I should see "Bienvenidos a Quiero Torneos ordenados"

Scenario: Intentar inscribirme al torneo bloodzone sin estar logeado

Given I open the web application
Then I press button "Inscribirme" to "Starcraft2" tournament
Then I should see "Torneo Bloodzone"
Then I press link "inscripcion"
Then I should see "Debes logearte primero"
Then I should see "Nick: "
Then I should see "Password: "

Scenario: inscribirme al torneo bloodzone logeandome desde la inscripción

Given I open the web application
Then I press button "Inscribirme" to "Starcraft2" tournament
Then I should see "Torneo Bloodzone"
Then I press link "inscripcion"
Then I should see "Debes logearte primero"
Then I should see "Nick: "
Then I should see "Password: "
Then I press button "Ingresar"
Then I should see "Listo!! Ya estas inscrito"
Then I should not see "Debes logearte primero"

Scenario: Inscribirme al torneo bloodzone estando logeado

Given I open the web application
Then I press button "Inscribirme" to "Starcraft2" tournament
Then I should see "Torneo Bloodzone"
Then I press link "Inscripción"
Then I should see "Listo!! Ya estas inscrito"