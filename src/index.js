/**
 * Index - this is where everything
 *  starts - but offloads to app.js
 *
 * React Native Starter App
 * https://github.com/mcnamee/react-native-starter-app
 */
/* global __DEV__ */
import React from 'react';
import { applyMiddleware, compose, createStore } from 'redux';
import { connect, Provider } from 'react-redux';
import { createLogger } from 'redux-logger';
import thunk from 'redux-thunk';
import { Router } from 'react-native-router-flux';

import '@constants/global';

// Consts and Libs
import { AppStyles } from '@theme/';
import AppRoutes from '@navigation/';

// All redux reducers (rolled into one mega-reducer)
import rootReducer from '@apis/index';

import stacktraceParser from 'stacktrace-parser';
// import App from '@containers/AppContainer';

const parseErrorStack = (error) => {
    if (!error || !error.stack) {
        return [];
    }
    return Array.isArray(error.stack) ? error.stack :
    stacktraceParser.parse(error.stack);
};


// intercept react-native error handling
if (ErrorUtils._globalHandler) {
    this.defaultHandler = (ErrorUtils.getGlobalHandler
        && ErrorUtils.getGlobalHandler())
        || ErrorUtils._globalHandler;
    ErrorUtils.setGlobalHandler(this.wrapGlobalHandler); // feed errors directly to our wrapGlobalHandler function
}

async function wrapGlobalHandler(error, isFatal) {

    const stack = parseErrorStack(error);

    //do anything with the error here

    this.defaultHandler(error, isFatal);  //after you're finished, call the defaultHandler so that react-native also gets the error
}

// Connect RNRF with Redux
const RouterWithRedux = connect()(Router);

// Load middleware
let middleware = [
	thunk, // Allows action creators to return functions (not just plain objects)
];

if (__DEV__) {
	// Dev-only middleware
	middleware = [
		...middleware,
		createLogger(), // Logs state changes to the dev console
	];
}

// Init redux store (using the given reducer & middleware)
const store = compose(
	applyMiddleware(...middleware),
)(createStore)(rootReducer);

/* Component ==================================================================== */
// Wrap App in Redux provider (makes Redux available to all sub-components)
export default function AppContainer() {
	return (
		<Provider store={store}>
			<RouterWithRedux scenes={AppRoutes} style={AppStyles.appContainer} />
		</Provider>
	);
}