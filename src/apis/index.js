/**
 * Combine All Reducers
 *
 * React Native Starter App
 * https://github.com/mcnamee/react-native-starter-app
 */

import { combineReducers } from 'redux';

// Combine all
const appReducer = combineReducers({
});

// Setup root reducer
const rootReducer = (state, action) => {
	const newState = (action.type === 'RESET') ? undefined : state;
	return appReducer(newState, action);
};

export default rootReducer;