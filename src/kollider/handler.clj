(ns kollider.handler
  (:require [kollider.routes.site :refer [site-routes]]
            [compojure.core :refer [defroutes]]
            [compojure.route :as route]
            [noir.util.middleware :refer [app-handler]]
            [noir.util.cache :as cache]))

(defroutes base-routes
  (cache/cache! :resources (route/resources "/"))
  (route/not-found "Not Found"))

(def app (app-handler
           [site-routes]))
