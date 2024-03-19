# Diff generator
[![Actions Status](https://github.com/niyatanya/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/niyatanya/java-project-71/actions)
[![Java CI with Gradle](https://github.com/niyatanya/java-project-71/actions/workflows/gradle.yml/badge.svg)](https://github.com/niyatanya/java-project-71/actions/workflows/gradle.yml)
[![Test Coverage](https://api.codeclimate.com/v1/badges/f70dc800989ad79e3fe2/test_coverage)](https://codeclimate.com/github/niyatanya/java-project-71/test_coverage)
[![Maintainability](https://api.codeclimate.com/v1/badges/f70dc800989ad79e3fe2/maintainability)](https://codeclimate.com/github/niyatanya/java-project-71/maintainability)

JSON and YML compare tool. Generates report in three different formats: stylish, plain and json.

## Run
```
make run-dist
```

## Setup
```
make build
```

## Usage
```
gendiff [-hV] [-f=<format>] filepath1 filepath2
```
`filepath1` - path to first file

`filepath2` - path to second file

`-f, --format=<format>`  - output format [default: stylish]

`-h, --help` - Show help message and exit.

`-V, --version` - Print version information and exit.


## Preview
[![asciicast](https://asciinema.org/a/647700.svg)](https://asciinema.org/a/647700)
