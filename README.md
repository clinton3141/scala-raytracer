# What is this?

I got my hands on a copy of [The Ray Tracer Challenge](https://pragprog.com/titles/jbtracer/the-ray-tracer-challenge/) and thought I'd give it a go in Scala. This is that attempt.

## Running tests

The tests in this project are written as BDD tests. Yeah I know -  that seems a bit strange - they might be better as TDD. But that's how they're presented in the book. The goal here is to practice Scala, so I'll leave them as-is as the path of least friction.

To run them:

* `sbt test`

## Compiling

* `sbt compile`

## Formatting

* `sbt scalafmt` - formats just files in `src`
* `sbt scalafmtAll` - formats _all_ `.scala` files
* `sbt scalafmtCheck` - checks just files in  `src` files
* `sbt scalafmtCheckAll` - checks _all_ `.scala` files
