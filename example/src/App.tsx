import * as React from 'react';

import { Button, StyleSheet, Text, View } from 'react-native';
import {
  isDeveloperModeEnabled,
  openDeveloperSettings,
} from 'react-native-developer-options';

export default function App() {
  const [result, setResult] = React.useState<string>('/');

  React.useEffect(() => {
    isDeveloperModeEnabled().then((isEnabled) => {
      setResult(isEnabled ? 'yes' : 'no');
    });
  }, []);

  return (
    <View style={styles.container}>
      <Text>Is developer mode enabled: {result}</Text>
      <Button
        title="Open developer settings"
        onPress={() => {
          openDeveloperSettings();
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
