(defproject kollider "0.1.0-SNAPSHOT"
  :description "anonymous code board"
  :url "https://github.com/bryangarza/kollider"
  :min-lein-version "2.0.0"
  :license {:name "GPLv3"
            :url "http://www.gnu.org/licenses/gpl-3.0.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [hiccup "1.0.5"]
                 [ring/ring-defaults "0.1.3"]
                 [ring/ring-anti-forgery "1.0.0"]]
  :plugins [[lein-ring "0.9.1"]]
  :ring {:handler kollider.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
