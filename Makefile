
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
	@if [ -n "$( git remote -v | grep ScalaTemplate | grep __template__ )" ]; then \
		git remote add __template__ "git@github.com:ledyba/ScalaTemplate.git"; \
	fi
	git fetch __template__
	git merge __template__/master
