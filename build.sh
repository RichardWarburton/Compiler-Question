#!/bin/sh

mkdir bin || rm bin/*
javac -d bin/ src/JavacFail.java
