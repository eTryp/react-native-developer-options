# react-native-developer-options

Check if the device has the developer options enabled

## Installation

```sh
npm install react-native-developer-options
```

## Usage

```js
import {
  isDeveloperModeEnabled,
  openDeveloperSettings,
} from 'react-native-developer-options';

// ...
const result = await isDeveloperModeEnabled();
if (result === true) {
  openDeveloperSettings();
}
// ...
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
