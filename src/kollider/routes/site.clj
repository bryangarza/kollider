(ns kollider.routes.site
  (:require [compojure.core :refer [defroutes GET]]
            [kollider.layout :as layout]))

(defn home-page []
  (layout/render "app.html"))

(defroutes site-routes
  (GET "/" [] (home-page)))
