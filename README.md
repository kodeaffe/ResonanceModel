# ResonanceModel

Just a little implementation of a harmonic oscillator.

It takes the Amplitude, Omega 0 and the Q factor as arguments, as well as a
filename where computed data will be written to in a simple text format.

It was written using Java 8u131, documentation can be found in `docs/`

## Run

### Precompiled JAR file

```bash
$ java -jar resonancemodel.jar <amplitude> <omega0> <qfactor> <filename>
```

### Self-compiled

```bash
$ javac resonancemodel/Main.java
$ java resonancemodel/Main <amplitude> <omega0> <qfactor> <filename>
```


## Create JAR file

```bash
$ jar cmvf META-INF/MANIFEST.MF resonancemodel.jar resonancemodel/
```


## Create docs

```bash
$ javadoc -d docs/ resonancemodel
```
