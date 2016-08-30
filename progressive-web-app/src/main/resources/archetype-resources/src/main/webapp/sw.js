var cacheName = '${artifactId}';  
var filesToCache = [ '/',
                     '${module}.html',  
                     'polymer-imports.html',
                     'manifest.json', 
                     'styles/styles.css',
                     '${module}/bower_components/webcomponentsjs/webcomponents.js',
                     '${module}/bower_components/polymer/polymer.html',
                     '${module}/bower_components/polymer/polymer-mini.html',
                     '${module}/bower_components/iron-pages/iron-pages.html',
                     '${module}/bower_components/iron-icons/iron-icons.html',
                     '${module}/bower_components/iron-icons/maps-icons.html',
                     '${module}/bower_components/iron-selector/iron-selector.html',
                     '${module}/bower_components/iron-selector/iron-multi-selectable.html',
                     '${module}/bower_components/iron-resizable-behavior/iron-resizable-behavior.html',
                     '${module}/bower_components/iron-selector/iron-selectable.html',
                     '${module}/bower_components/iron-selector/iron-selection.html',
                     '${module}/bower_components/iron-a11y-keys-behavior/iron-a11y-keys-behavior.html',
                     '${module}/bower_components/iron-behaviors/iron-button-state.html',
                     '${module}/bower_components/paper-drawer-panel/paper-drawer-panel.html',
                     '${module}/bower_components/paper-icon-button/paper-icon-button.html',
                     '${module}/bower_components/paper-item/paper-item.html',
                     '${module}/bower_components/paper-menu/paper-menu.html',
                     '${module}/bower_components/paper-toast/paper-toast.html',
                     '${module}/bower_components/paper-button/paper-button.html',
                     '${module}/bower_components/paper-material/paper-material.html',
                     '${module}/bower_components/paper-material/paper-material-shared-styles.html',
                     '${module}/bower_components/font-roboto/roboto.html',
                     '${module}/bower_components/paper-ripple/paper-ripple.html',
                     '${module}/bower_components/paper-behaviors/paper-button-behavior.html',
                     '${module}/bower_components/paper-behaviors/paper-ripple-behavior.html',
                     '${module}/bower_components/iron-flex-layout/iron-flex-layout.html',
                     '${module}/bower_components/paper-header-panel/paper-header-panel.html',
                     '${module}/bower_components/paper-styles/typography.html',
                     '${module}/bower_components/paper-styles/shadow.html',
                     '${module}/bower_components/paper-styles/default-theme.html',
                     '${module}/bower_components/paper-toolbar/paper-toolbar.html',
                     '${module}/bower_components/iron-image/iron-image.html',
                     '${module}/bower_components/paper-card/paper-card.html',
                     'resources/gwt.png',
                     'resources/image-splash.png',
                     'sw.js',
                      '${module}/${module}.nocache.js'];

/* compiler browsers mappings should also be added to the list 
 * 
 * for example: 
 *                     '${module}/041227C954C659AC17AA11A88D7122AB.cache.js',
                      '${module}/2ED153541DC20AD79D3A609C73A72DDD.cache.js',
                      '${module}/775B37172E0075A54A16526533C6A56A.cache.js',
                      '${module}/996A49EB05A962F405E0C590B4D9DBC0.cache.js',
                      '${module}/E5FD95135DCB346198E89EAABFFFDC52.cache.js'
 * 
 * 
 * 
 * **/

self.addEventListener('install', function(e) {  
  console.log('[ServiceWorker] Install');  
  e.waitUntil(  
    caches.open(cacheName).then(function(cache) {  
      console.log('[ServiceWorker] Caching app shell');  
      return cache.addAll(filesToCache);  
    })  
  );  
});


self.addEventListener('activate', function(e) {  
    console.log('[ServiceWorker] Activate');  
    e.waitUntil(  
      caches.keys().then(function(keyList) {  
        return Promise.all(keyList.map(function(key) {  
          console.log('[ServiceWorker] Removing old cache', key);  
          if (key !== cacheName) {  
            return caches.delete(key);  
          }  
        }));  
      })  
    );  
  });

self.addEventListener('fetch', function(e) {  
    console.log('[ServiceWorker] Fetch', e.request.url);  
    e.respondWith(  
      caches.match(e.request).then(function(response) {  
        return response || fetch(e.request);  
      })  
    );  
  });