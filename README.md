# Screenmatch

Projeto Java orientado a objetos para modelar filmes, series e episodios, com calculo de tempo total e filtro de recomendacao.

## Objetivo

Este projeto demonstra conceitos basicos de:
- classes e objetos
- heranca (classe `Titulo` como base)
- polimorfismo (`Filme` e `Serie` como tipos de `Titulo`)
- interfaces (`Classificavel`)
- encapsulamento com getters e setters

## Estrutura do Projeto

```text
src/
  Principal.java
  br/com/westes/screenmatch/
    calculos/
      CalculadoraDeTempo.java
      Classificavel.java
      FiltroRecomendacao.java
    modelos/
      Episodio.java
      Filme.java
      Serie.java
      Titulo.java
```

## Como Executar

### Requisitos
- Java JDK 17+ (ou versao compativel com seu ambiente)

### Compilar via terminal (Windows)
Na raiz do projeto:

```powershell
javac -encoding UTF-8 -d out src\Principal.java src\br\com\westes\screenmatch\calculos\*.java src\br\com\westes\screenmatch\modelos\*.java
```

### Rodar

```powershell
java -cp out Principal
```

## Exemplo de Saida Esperada

```text
Tempo total: 2486
Esta entre os preferidos
```

## Publicar no GitHub (Deploy do Codigo)

1. Crie um repositorio vazio no GitHub (sem README, sem .gitignore, sem license).
2. No projeto local, configure o remoto:

```powershell
git remote add origin https://github.com/SEU_USUARIO/screenmatch.git
```

Se o remoto `origin` ja existir, atualize:

```powershell
git remote set-url origin https://github.com/SEU_USUARIO/screenmatch.git
```

3. Commit inicial (se ainda nao fez):

```powershell
git add .
git commit -m "chore: estrutura inicial do projeto screenmatch"
```

4. Envie para o GitHub:

```powershell
git branch -M main
git push -u origin main
```

## Melhorias Futuras

- Implementar nota/classificacao para `Filme` e `Serie`.
- Adicionar testes unitarios com JUnit.
- Migrar para estrutura Maven ou Gradle.
- Criar CI com GitHub Actions para compilar automaticamente a cada push.
