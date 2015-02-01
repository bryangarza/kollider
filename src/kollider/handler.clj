(ns kollider.handler
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.page :refer [html5 include-css]]
            [clojure.pprint :refer [pprint]]))

(def board-fp (atom [["Hello" "OMG" "yo"] ["fun" "asdfasdf" "asa"]]))
(def board-brace (atom [["write less JS" "nothx" "ok"] ["IDK" "what is this" "asdf"] ["pointless" "yea"]]))

(defn as-ul [v]
  [:ul (map (fn [item] [:li (str item)]) v)])

(defn content-to-ul [c]
  [:ul (map (fn [item] [:li (str (first item)) (as-ul (rest item))]) c)])

(defn common [& body]
  (html5
   [:head
    [:title "Kollider"]
    (include-css "/css/screen.css")]
   [:body body]))

(defn form-post [route]
  [:form {:method "post" :action "/fp"}
           [:input {:type "text" :name "submission"}]
           [:input {:type "submit" :value "Submit"}]])

(defn home []
  (common
   [:h1 "Kollider"]
   [:p "paragraph"]
   [:p [:ul
        [:li
         "Functional Programming"
         (content-to-ul @board-fp)
         (form-post "/fp")
         [:li "Curly brace langs" (content-to-ul @board-brace)]]]]))

(defroutes app-routes
  (GET "/" [] (home))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
