# I.BA_AD.F2302

## Modulbeschrieb
Fundierte Einführung in grundlegende Datenstrukturen und Algorithmen sowie in übergeordnete Prinzipien wie Iteration, Rekursion und Teile und Herrsche. In diesem Kontext wichtig ist auch die Parallelisierung, konkret die nebenläufige Programmierung mit Java. Das Modul vermittelt essentielle Grundlagen und befähigt zum praktischen Anwenden und Implementieren. Topics sind z.B. Listen, Bäume, Hashtabellen, weiter Sortier-, Such- und Graphenalgorithmen sowie aktuelle Java Frameworks.

### Inhalt



## Zweck
Dieses Projekt dient in den Modulen OOP/PLAB, PRG, AD, VSK, SWDE und SWDA als 
Template fuer einfache Java-Projekte. Es nutzt einen auf 
[Apache Maven](https://maven.apache.org/) basierenden (und somit IDE-unabhaengigen) 
Build und definiert die dafuer notwendige, standardisierte Verzeichnisstruktur.

## Enhaltene Libraries (Dependencies)
* JUnit 5 - https://junit.org/junit5/
* JUnit Pioneer - https://junit-pioneer.org/
* AssertJ - https://assertj.github.io/doc/
* EqualsVerifier - https://jqno.nl/equalsverifier/
* Logging Framework - https://logging.apache.org/log4j/2.x/
* MutabilityDetector - https://github.com/MutabilityDetector/MutabilityDetector
* Log Captor - https://github.com/Hakky54/log-captor

## Integrierte Analysewerkzeuge (Code Qualitaet)
* Checkstyle - https://checkstyle.sourceforge.io/
* PMD - https://pmd.github.io/
* JaCoCo - https://www.eclemma.org/jacoco/
* Spotbugs - https://spotbugs.github.io/
* Snyk - https://snyk.io/ (benoetigt Account und zusaetzliche Konfiguration)

## Weitere Integrationen (benoetigen ggf. Konfiguration/Account)
* [GitLab CI/CD](https://docs.gitlab.com/ee/ci/) (.gitlab-ci.yml) inkl. Coverageauswertung fuer Java.
* Dockerfile fuer Bau eines [Docker-Images](https://www.docker.com/)
* [AsciiDoctor-Plugin](https://asciidoctor.org/) fuer [AsciiDoc](https://asciidoc.org/)
* [Fabric/Docker-Plugin](https://dmp.fabric8.io/) fuer Build und Deploy auf [DockerHub](https://hub.docker.com/)
* [JIB-Plugin](https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin) (Google) fuer Build und Deploy auf DockerHub (alternative).

