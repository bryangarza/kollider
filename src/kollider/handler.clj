(ns kollider.handler
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [hiccup.page :refer [html5 include-css]]))

(defn common [& body]
  (html5
   [:head
    [:title "Kollider"]
    (include-css "/css/screen.css")]
   [:body body]))

(defn home []
  (common
   [:h1 "Kollider"]
   [:p "paragraph"]))

(defroutes app-routes
   (GET "/" [] (home))
   (route/resources "/")
   (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
