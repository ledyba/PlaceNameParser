
.PHONY: all jar run reload test install update template

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

template:
	@(git remote remove __template__ || true) > /dev/null 2>&1
	@(git remote add __template__ "https://github.com/ledyba/ScalaTemplate.git" || true) > /dev/null 2>&1
	git fetch __template__
	git merge __template__/master
