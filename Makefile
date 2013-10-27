
.PHONY: all jar run reload test install update

all:
	sbt compile

jar:
	sbt assembly

run:
	sbt run

reload: update
	sbt eclipse

update:
	sbt reload update-classifiers

test:
	sbt test

install:
	sbt publishLocal publishM2
