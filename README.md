##kollider
- kind of like 4chan, but for code.
- code must be required for all posts.
- replies will have optional code.
- will start off with boards /c-like/, /fp/, /algo/, and /other/
- will have syntax highlighting.

###setup
- clone this repo.
- to build: `lein cljsbuild auto`

###stack
- Front-end: [Reagent](https://github.com/reagent-project/reagent)
- Routing: [Compojure](https://github.com/weavejester/compojure)
- Server: [HTTP kit](https://github.com/http-kit/http-kit)
- Templating: [Selmer](https://github.com/yogthos/Selmer)
- Database: [Monger](https://github.com/michaelklishin/monger)
