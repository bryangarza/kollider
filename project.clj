(defproject kollider "0.1.0-SNAPSHOT"
  :description "anonymous code board"
  :url "N/A"
  :license {:name "GPLv3"
            :url "http://www.gnu.org/licenses/gpl-3.0.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [lib-noir "0.9.4"]
                 [compojure "1.2.1"]
                 [ring-server "0.3.1"]
                 [throttler "1.0.0"]
                 [environ "1.0.0"]
                 [selmer "0.7.3"]
                 [org.clojure/clojurescript "0.0-2371"]
                 [reagent "0.4.3"]
                 [cljs-ajax "0.3.3"]
                 [secretary "1.2.1"]]
  :ring {:handler kollider.handler/app}
  :cljsbuild {:builds[{:id "dev"
                       :source-paths ["src-cljs"]
                       :compiler {:output-to "resources/public/js/app.js"
                                  :output-dir "resources/public/js/"
                                  :optimizations :whitespace
                                  :preamble ["reagent/react.js"]
                                  :pretty-print true}}]}
  :profiles {:dev {:env {:dev true}}}
  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-ring "0.8.13"]
            [lein-environ "1.0.0"]])
